package com.amigoscode.notification;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

private final Notificationservice notificationservice;


  @PostMapping
  public void notificationRequest(@RequestBody NotificationRequest request)
  {
      log.info("New notification request is {}",request);
      notificationservice.send(request);
  }
    
}
