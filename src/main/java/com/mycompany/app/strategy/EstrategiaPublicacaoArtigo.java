package com.mycompany.app.strategy;

import com.mycompany.app.Interface.PublicavelInterface;

public class EstrategiaPublicacaoArtigo implements PublicavelInterface {
    @Override
    public String publicar() {
        return "Publicação de artigo realizada";
    }
}
