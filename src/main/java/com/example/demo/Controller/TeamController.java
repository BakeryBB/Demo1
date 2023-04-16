
package com.example.demo.Controller;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.engine.AttributeName;

import com.example.demo.model.Team;
import com.example.demo.repositories.TeamRepo;
import com.example.demo.services.TeamService;

import aj.org.objectweb.asm.Attribute;
 
@Controller
@RequestMapping("/team")
public class TeamController {
 

@Autowired
private TeamService teamService;

    @RequestMapping("/list")
    public String getList(Model model){
        model.addAttribute("teamlist", teamService.getTeamList());
        return "AllTeams";
    }
@RequestMapping("/add")
public String addTeam(Model model){

model.addAttribute("team", new Team());

    return "AddTeam";

    //teams.add(team);
}

@PostMapping("/add")
public String confirmNewTeam(@ModelAttribute("team") Team team){
    teamService.newTeam(team);
    return "home";
}

    }

