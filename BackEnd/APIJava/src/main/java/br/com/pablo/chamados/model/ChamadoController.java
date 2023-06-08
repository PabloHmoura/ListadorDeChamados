package br.com.pablo.chamados.model;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chamado")
@CrossOrigin(origins = "http://localhost:5173")
public class ChamadoController {

    ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public List<Chamado>retornaChamados() throws IOException, InterruptedException, ParseException {
        return chamadoService.listar();
    }
}