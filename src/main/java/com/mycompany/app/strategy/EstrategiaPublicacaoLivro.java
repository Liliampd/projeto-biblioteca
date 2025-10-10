package com.mycompany.app.strategy;

import com.mycompany.app.Interface.PublicavelInterface;

public class EstrategiaPublicacaoLivro implements PublicavelInterface {
    @Override
    public String publicar() {
        return "Publicação de livro realizada";
    }
}
