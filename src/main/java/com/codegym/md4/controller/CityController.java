package com.codegym.md4.controller;

import com.codegym.md4.model.City;
import com.codegym.md4.service.ICityService;
import com.codegym.md4.service.INationalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {
    private final ICityService cityService;
    private final INationalService nationalService;
    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String name) {
        return new ModelAndView("index")
                .addObject("listCity", cityService.findByName(name))
                .addObject(name);

    }
    @GetMapping("/add")
    public ModelAndView showFormCreate() {
        return new ModelAndView("add")
                .addObject("listNationl", nationalService.getAllNational())
                .addObject("city", new City());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("city", cityService.getDetailCityBy(id))
                .addObject("national", nationalService.getAllNational());
    }
    @PostMapping("/add")
    public String addCity(@ModelAttribute @Valid City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành phố thành công!!");
        return "redirect:/city";
    }
    @PostMapping("/edit/{id}")
    public String updateCity(@PathVariable Long id, @ModelAttribute @Valid City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("success", "Sửa thông tin thành phố thành công!");
        return "redirect:/city";
    }
    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id, RedirectAttributes redirectAttributes) throws Exception {
        cityService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành phố thành công!");
        return "redirect:/city";
    }
}
