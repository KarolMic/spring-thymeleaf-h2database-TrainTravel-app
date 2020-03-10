package pl.karolmic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import pl.karolmic.model.TrainConnection;
import pl.karolmic.model.TrainConnectionBuilder;
import pl.karolmic.repository.SimpleCityRepository;
import pl.karolmic.repository.SimpleTrainConnectionRepository;

@Controller
public class TrainConnectionController {

    @Autowired
    private SimpleCityRepository cityRepository;
    @Autowired
    private SimpleTrainConnectionRepository trainConnectionRepository;
    @Autowired
    private TrainConnectionBuilder trainConnectionBuilder;
    @Autowired
    TrainConnection trainConnection;


    @GetMapping(value={"/", "/home"})
    public String showAll(Model model) {
        model.addAttribute("cities",
                cityRepository.findAll());
        model.addAttribute("connections", trainConnectionRepository.findAll());
        return "home.html";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @RequestMapping("/logout")
    public String logoutPage() {
        return "home.html";
    }

    @RequestMapping(value="searchedConnections", method=RequestMethod.POST)
    public String searchedConnectionsPage(Model model, @RequestParam String cityName) {
        model.addAttribute("cityName", cityName);
        model.addAttribute("connections",
        trainConnectionRepository.findByDepartureCityOrArrivalCity(cityRepository.findByName(cityName),
                cityRepository.findByName(cityName)));
        return "searchedConnections.html";
    }

    @GetMapping("/connectionsManagement")
    public String ConnectionManagement(Model model) {
        model.addAttribute("connections", trainConnectionRepository.findAll());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("loggedUser",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "connectionsManagement.html";
    }

    @RequestMapping(value="/trainConnection", method=RequestMethod.POST)
    public RedirectView addNewConnection(Model model, @RequestParam String departureCity, @RequestParam String arrivalCity,
                                         @RequestParam String transportDate) {
        trainConnection.setDepartureCity(cityRepository.findByName(departureCity));
        trainConnection.setArrivalCity(cityRepository.findByName(arrivalCity));
        trainConnection.setTransportDate(transportDate);
        trainConnectionRepository.save(trainConnection);
        return new RedirectView("http://localhost:8080/connectionsManagement");
    }

    @RequestMapping(value = "/deleteConnection", method=RequestMethod.POST)
    public RedirectView delete(Model model, @RequestParam String id) {
        trainConnectionRepository.delete(trainConnectionRepository.findById(id));
        return new RedirectView("http://localhost:8080/connectionsManagement");
    }

    @RequestMapping(value = "/updateConnection", method=RequestMethod.POST)
    public String update(Model model, @RequestParam String id) {
        model.addAttribute("connection", trainConnectionRepository.findById(id));
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("loggedUser",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "updateConnection.html";
    }

    @RequestMapping(value="/editConnection", method=RequestMethod.POST)
    public RedirectView editConnection(@RequestParam String id, @RequestParam String departureCity, @RequestParam String arrivalCity,
                                       @RequestParam String transportDate) {

        TrainConnection trainConnection = trainConnectionBuilder
                .withId(id)
                .withDepartureCity(departureCity)
                .withArrivalCity(arrivalCity)
                .withTransportDate(transportDate)
                .build();

        trainConnectionRepository.save(trainConnection);

        return new RedirectView("http://localhost:8080/connectionsManagement");
    }

}
