package wizut.tpsi.lab9;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    
    @Autowired
    private BlogRepository blogrepository;
    
    @RequestMapping("/")
    public String blog(Model model) throws SQLException{
        
        List<BlogPost> dane = blogrepository.getAllPosts();
        
        model.addAttribute("dane", dane);
        
        return "blog";
    }
    
    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        
    blogrepository.createPost(post);
    
    return "redirect:/";
}
    @PostMapping("/removepost")
    public String removePost(BlogPost post, Long usun) throws SQLException{
        
        blogrepository.removePost(post, usun);
        
        return "redirect:/";
    }
}
