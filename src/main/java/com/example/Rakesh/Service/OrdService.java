package com.example.Rakesh.Service;

import com.example.Rakesh.Payload.OrdDto;
import com.example.Rakesh.Repository.OrdRepository;
import com.example.Rakesh.entity.Ord;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class OrdService {

    private OrdRepository ordRepository;

    private ModelMapper modelMapper;

    public OrdService(OrdRepository ordRepository,ModelMapper modelMapper) {
        this.ordRepository = ordRepository;
        this.modelMapper=modelMapper;
    }

    public Ord setOrd(Ord ord) {
        return ordRepository.save(ord);
    }

    public List<OrdDto> getOrd() {
        List<Ord> all = ordRepository.findAll();
        return modelMapper.map(all, List.class);
    }

    public Ord mapToEntity(OrdDto ordDto){
        Ord toEntity = modelMapper.map(ordDto, Ord.class);
        return toEntity;
    }

    public OrdDto mapToDto(Ord ord){
        OrdDto toDto = modelMapper.map(ord, OrdDto.class);
        return toDto;
    }

    public Ord getDetailsById(Long id){
        Ord ord = ordRepository.findById(id).orElseThrow(()->new ResolutionException("Data not found"));
        return ord;
    }
}
