package sia.tacocloud.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

import sia.tacocloud.tacos.TacoOrder;
import sia.tacocloud.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    
    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        // model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }
    @PostMapping
    public String ProcessOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("order: " + order);
        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
