package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Team;
import com.example.demo.repositories.TeamRepo;  

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    public Team newTeam(Team team){
       return teamRepo.save(team);
    }

    public List<Team> getTeamList(){
        return teamRepo.findAll();
    }

}
