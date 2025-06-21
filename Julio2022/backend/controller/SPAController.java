package Julio2022.backend.controller;

// Imports

// Hay que hacer este controller SPA por separado porque en el enunciado aparece:
// La aplicación web tradicional estará en la raíz de la URL (http://localhost/) y la aplicación SPA
// estará en (http://localhost/new/).

@Controller
public class SPAController {
    
    @GetMapping({ "/new/**/{path:[^\\.]*}", "/{path:new[^\\.]*}" })
    public String getSpa() {
        return "forward:/new/index.html";
    }
}