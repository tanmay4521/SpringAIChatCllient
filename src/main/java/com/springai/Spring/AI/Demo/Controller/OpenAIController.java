package com.springai.Spring.AI.Demo.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OpenAIController
{
//    private OpenAiChatModel chatModel;
    private ChatClient chatClient;
    public OpenAIController(OpenAiChatModel chatModel)
    {
//        this.chatModel=chatModel;
        this.chatClient= ChatClient.create(chatModel);
    }
    @GetMapping("/")
    public String indexPage()
    {
        return "index";
    }
    @PostMapping("/chat")
    public String responsePage(@RequestParam("userMessage") String userMessage, Model m)
    {
//        String response=chatModel.call(userMessage);
        String response=chatClient.prompt(userMessage).call().content();
        m.addAttribute("response",response);
        return "index";
    }

}
