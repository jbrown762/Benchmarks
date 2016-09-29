package org.ssa.ironyard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.ssa.ironyard.model.Framework;
import org.ssa.ironyard.service.FrameworkService;
import org.ssa.ironyard.service.LanguageService;
import org.ssa.ironyard.service.ServerService;

@RestController
@RequestMapping("/framework")
public class FrameworkController
{
    final FrameworkService frameworkService;
    final LanguageService languageService;
    final ServerService serverService;

    //final Logger LOGGER = LogManager.getLogger(FrameworkController.class);

    @Autowired
    public FrameworkController(FrameworkService benchmarkService, LanguageService languageService,
            ServerService serverService)
    {
        this.frameworkService = benchmarkService;
        this.languageService = languageService;
        this.serverService = serverService;
    }

    @RequestMapping("framework/{frameworkId}")
    public ResponseEntity<Framework> getFramework(@PathVariable int frameworkId)
    {
        return ResponseEntity.ok().body(frameworkService.readFramework(frameworkId));
    }

    @RequestMapping("")
    public View initialView()
    {
        return new InternalResourceView("framework.html");
    }
}