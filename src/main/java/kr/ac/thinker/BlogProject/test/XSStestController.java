package kr.ac.thinker.BlogProject.test;

import kr.ac.thinker.BlogProject.model.StoredContent;
import kr.ac.thinker.BlogProject.repository.StoredContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class XSStestController {

    private String storedContent;
    private final StoredContentRepository storedContentRepository;

    @Autowired
    public XSStestController(StoredContentRepository storedContentRepository) {
        this.storedContentRepository = storedContentRepository;
    }

    @GetMapping("/test/reflected")
    public String reflected(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "xss/reflected";
    }

    @GetMapping("/test/store-form")
    public String showStoreForm() {
        return "xss/store-form";
    }

    @PostMapping("/test/store")
    public String storeContent(@RequestParam String content) {
        StoredContent storedContent = new StoredContent();
        storedContent.setContent(content);
        storedContentRepository.save(storedContent);
        return "redirect:/test/display";
    }

    @GetMapping("/test/display")
    public String displayContent(Model model) {
        StoredContent storedContent = storedContentRepository.findById(1L).orElse(null);
        if (storedContent != null) {
            model.addAttribute("content", storedContent.getContent());
        }
        return "xss/stored";
    }
}
