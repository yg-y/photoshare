package com.photoshare.websocket.controller;

import com.photoshare.websocket.SocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/message")
public class WebSocketController {

    @GetMapping("/send")
    public String sendMessage(@RequestParam("id") String id) {
        try {
            SocketServer.sendInfo("server send message", id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
