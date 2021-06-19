package ecommerce.spring.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.spring.enties.Demo;
import ecommerce.spring.repository.DemoRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class DemoController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("demo")
    public Collection<Demo> getAll() {
        return this.demoRepository.findAll();
    }

    @PostMapping("upload")
    @ResponseStatus(HttpStatus.CREATED)
    public Demo create(@RequestParam String title, @RequestParam MultipartFile image) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
        Demo user = new Demo();
        user.setTitle(title);
        user.setImagePath(imagePath.resolve(image.getOriginalFilename()).toString());
        return demoRepository.save(user);
    }
}
