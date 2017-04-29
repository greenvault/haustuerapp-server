package de.gruene.haustuer.door;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/door")
public class DoorController {

  private static Logger logger = LoggerFactory.getLogger(DoorController.class);

  @Autowired
  DoorService doorService;

  @GetMapping
  public List<Door> getDoors(@RequestParam(required = false) String district) {
    logger.info("Value of district={}", district);

    return Arrays.asList(new Door(), new Door(), new Door());
  }

  @GetMapping("{id}")
  public Door getDoor(@PathVariable Long id) {
    return doorService.getDoorById(id);
  }

  @PostMapping
  public Door createDoor(@Valid @RequestBody Door door) {
    doorService.save(door);
    return door;
  }

}
