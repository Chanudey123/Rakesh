package com.example.Rakesh.Controller;

import com.example.Rakesh.Payload.OrdDto;
import com.example.Rakesh.Repository.OrdRepository;
import com.example.Rakesh.Service.OrdService;
import com.example.Rakesh.entity.Ord;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ord")
public class OrdController {

    private OrdService ordService;
    private OrdRepository ordRepository;
    public OrdController(OrdService ordService, OrdRepository ordRepository) {
        this.ordService = ordService;
        this.ordRepository = ordRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> setOrdDetails(@Valid @RequestBody Ord ord, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Ord saveOrd = ordService.setOrd(ord);
        return new ResponseEntity<>(saveOrd, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<OrdDto>> getOrdDetails(){
        List<OrdDto> ord = ordService.getOrd();
        return new ResponseEntity<>(ord, HttpStatus.OK);
    }

    @GetMapping("get")
    public ResponseEntity<Ord>getOrdDetailsById(@RequestParam Long id){
        Ord detailsById = ordService.getDetailsById(id);
        return new ResponseEntity<>(detailsById, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrd(@RequestParam Long id){
        ordRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
