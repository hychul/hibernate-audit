package com.hychul.hibernate.audit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hychul.hibernate.audit.controller.model.ManyDto;
import com.hychul.hibernate.audit.controller.model.OneDto;
import com.hychul.hibernate.audit.repository.model.OneModel;
import com.hychul.hibernate.audit.service.ManyModelService;
import com.hychul.hibernate.audit.service.OneModelService;
import com.hychul.hibernate.audit.repository.model.ManyModel;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final ManyModelService manyModelService;
    private final OneModelService oneModelService;

    public DemoController(ManyModelService manyModelService, OneModelService oneModelService) {
        this.manyModelService = manyModelService;
        this.oneModelService = oneModelService;
    }

    @GetMapping("/ones/{id}")
    public OneDto getOneModel(@PathVariable Long id) {
        return convert(oneModelService.get(id));
    }

    @PostMapping("/ones")
    public OneDto updateOneModel(@RequestBody OneDto oneModel) {
        return convert(oneModelService.update(convert(oneModel)));
    }

    @GetMapping("/manys/{id}")
    public ManyDto getManyModel(@PathVariable Long id) {
        return convert(manyModelService.get(id));
    }

    @PostMapping("manys")
    public ManyDto updateManyModel(@RequestBody ManyDto entity) {
        return convert(manyModelService.update(convert(entity)));
    }

    private OneModel convert(OneDto oneDto) {
        return new OneModel(oneDto.id, oneDto.name);
    }

    private OneDto convert(OneModel oneModel) {
        return new OneDto(oneModel.id, oneModel.name);
    }

    private ManyModel convert(ManyDto manyDto) {
        return new ManyModel(manyDto.id, manyDto.name, convert(manyDto.oneDto));
    }

    private ManyDto convert(ManyModel manyModel) {
        return new ManyDto(manyModel.id, manyModel.name, convert(manyModel.oneModel));
    }
}
