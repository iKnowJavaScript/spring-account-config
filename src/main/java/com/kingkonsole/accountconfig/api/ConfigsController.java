package com.kingkonsole.accountconfig.api;

import com.kingkonsole.accountconfig.models.Configs;
import com.kingkonsole.accountconfig.repositories.ConfigsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.bson.types.ObjectId;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/configs")
public class ConfigsController {
    @Autowired
    private ConfigsRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Configs> getAllConfigs() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Configs getConfigById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Configs configs) {
        configs.set_id(id);
        repository.save(configs);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Configs createConfig(@Valid @RequestBody Configs configs) {
        configs.set_id(ObjectId.get());
        repository.save(configs);
        return configs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteConfig(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}