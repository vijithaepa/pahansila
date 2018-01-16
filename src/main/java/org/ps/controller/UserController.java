package org.ps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vepa on 21/9/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @GetMapping(value = "/")
  public ResponseEntity<String> greetingUser(){

    return new ResponseEntity<String>("Great start", HttpStatus.OK);
  }
}
