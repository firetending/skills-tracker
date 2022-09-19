package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String index() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn:</h2>" +
                "<ol>" +
                "<li>Javascript</li>" +
                "<li>Java</li>" +
                "<li>SQL</li>" +
                "</ol>" +
                "<a href='/form'>Create your Skills Tracker</a>" +
                "</body>" +
                "</html>";
    }

    public String getLanguageSelectWithIndex(int index) {
        return "<select name='language"+index+"'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='C++'>C++</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='SQL'>SQL</option>" +
                "<option value='Ruby'>Ruby</option>" +
                "</select>";
    }

    @GetMapping("form")
    public String formInput() {
        return "<html>" +
                "<body>" +
                    "<h1>Skills Tracker</h1>" +
                    "<h2>Programming Languages</h2>" +
                    "<form action='tracker' method='post'>" +
                        "<input type='text' name='user' placeholder='Name' required><br>" +
                        "<label for='language1'>My favorite language:</label><br>" +
                        getLanguageSelectWithIndex(1) +"<br>"+
                        "<label for='language1'>My 2nd favorite language:</label><br>" +
                        getLanguageSelectWithIndex(2) +"<br>"+
                        "<label for='language1'>My 3rd favorite language:</label><br>" +
                        getLanguageSelectWithIndex(3) +"<br>"+
                        "<input type='submit' value='Create Skills Tracker'" +
                "</body>" +
                "</html>";
    }

//    @PostMapping("form")
//    public String formOutput(@RequestParam String user, @RequestParam String language1,
//                             @RequestParam String language2, @RequestParam String language3) {
//        return "<html>" +
//                "<body>" +
//                "<h1>Skills Tracker</h1>" +
//                "<h2>"+user+"</h2>" +
//                "<ol>" +
//                "<li>"+language1+"</li>" +
//                "<li>"+language2+"</li>" +
//                "<li>"+language3+"</li>" +
//                "</ol>" +
//                "</body>" +
//                "</html>";
//    }

    @PostMapping("tracker")
    public String formOutputTable(@RequestParam String user, @RequestParam String language1,
                             @RequestParam String language2, @RequestParam String language3) {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>"+user+"</h2>" +
                "<style>" +
                    "table, td {" +
                        "border: 1px solid black" +
                    "}" +
                "</style>" +
                "<table>" +
                    "<tr><th>Favorite Languages</th></tr>" +
                    "<tr><td>"+language1+"</td></tr>" +
                    "<tr><td>"+language2+"</td></tr>" +
                    "<tr><td>"+language3+"</td></tr>" +
                "</table><br>" +
                "<a href='form'>Create another Skills Tracker</a><br>" +
                "<a href='/'>Back to Home</a>" +
                "</body>" +
                "</html>";
    }
}
