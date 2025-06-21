package Mayo2023.backend.controller;

// Imports

// Hay que hacer este controller SPA por separado porque en el enunciado aparece:
// La aplicación web tradicional estará en la raíz de la URL (http://localhost/) y la aplicación SPA
// estará en (http://localhost/next/).

@Controller
public class SPAController {
    
    @GetMapping({ "/next/**/{path:[^\\.]*}", "/{path:next[^\\.]*}" })
    public String getSpa() {
        return "forward:/next/index.html";
    }
}
