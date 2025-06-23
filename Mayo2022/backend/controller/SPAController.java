package Mayo2022.backend.controller;

@Controller
public class SPAController {
    
    @GetMapping({ "/next/**/{path:[^\\.]*}", "/{path:next[^\\.]*}" })
    public String getSpa() {
        return "forward:/next/index.html";
    }
}