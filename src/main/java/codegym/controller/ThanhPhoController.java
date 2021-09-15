package codegym.controller;

import codegym.model.QuocGia;
import codegym.model.ThanhPho;
import codegym.service.IQuocGiaService;
import codegym.service.IThanhPhoService;
import codegym.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ThanhPhoController {
    @Autowired
    IThanhPhoService iThanhPhoService;
    @Autowired
    IQuocGiaService iQuocGiaService;
    @ModelAttribute("quocGiaList")
    public ArrayList<QuocGia> quocGiaArrayList() {
        return iQuocGiaService.findAll();
    }
    @GetMapping("/home")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iThanhPhoService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("thanhpho", new ThanhPho());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute ThanhPho thanhPho){

        iThanhPhoService.save(thanhPho);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("thanhpho", new ThanhPho());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ThanhPho thanhPho = iThanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("thanhpho", thanhPho);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit( @ModelAttribute ThanhPho thanhPho, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            return modelAndView;
        }
        iThanhPhoService.save(thanhPho);
        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        ThanhPho thanhPho = iThanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("thanhpho", thanhPho);
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute ThanhPho thanhPho) {
        iThanhPhoService.remove(thanhPho);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        ThanhPho thanhPho = iThanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("thanhpho", thanhPho);
        return modelAndView;
    }
}
