package lottery.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lottery.backend.domain.Contender;

import lottery.backend.persistence.ContenderPersistence;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContenderController {

    @Inject
    ContenderPersistence contenderPersistence;

    //create contender in database
    @RequestMapping(
        value = "/contender/{firstname}/{lastname}", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Contender create(@PathVariable final String firstname, @PathVariable final String lastname) {

        return contenderPersistence.save(new Contender(firstname, lastname));
    }

    //draw random winner from the list of contenders and after it deletes all of them so a new lottery can start
    @RequestMapping(value = "/winner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String drawWinner() {
    	List<Contender> contenders = getAllContenders();

    	if(contenders != null && !contenders.isEmpty()){
    		Random random = new Random();
    	
    		int index = random.nextInt(contenders.size());
    		Contender contender = contenders.get(index);

    		String completeName = contender.getFirstname()+" "+contender.getLastname();

    		System.out.println("Lottery winner is: "+completeName);

    		contenderPersistence.deleteAll();
    		
    		return completeName;
    	} else {
    		return null;
    	}
    }

    //get all the contenders for the lottery
    @RequestMapping(value = "/contenders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contender> getAllContenders() {

        final List<Contender> resultList = new ArrayList<>();
        final Iterable<Contender> all = contenderPersistence.findAll();

        all.forEach(new Consumer<Contender>() {
                @Override
                public void accept(final Contender contender) {
                    resultList.add(contender);
                }
            });

        return resultList;
    }
}
