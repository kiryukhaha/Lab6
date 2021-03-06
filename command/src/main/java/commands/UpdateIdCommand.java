package commands;

import core.CollectionManager;
import core.CommandAsker;
import core.InputChecker;
import core.ResponseOutput;
import datee.City;
import datee.CityForwarding;

import java.time.ZonedDateTime;

public class UpdateIdCommand extends AbstractCommand{
    private final CollectionManager collectionManager;
    private final InputChecker inputChecker;
    private final CommandAsker commandAsker;

    public UpdateIdCommand(CollectionManager cm, InputChecker ic, CommandAsker ca) {
        this.collectionManager = cm;
        this.inputChecker = ic;
        this.commandAsker = ca;
    }

    @Override
    public boolean execute(String sArgument, Object oArgument) {

            long id = Long.parseLong(sArgument);
            if (collectionManager.removeByID(id)) {
                ResponseOutput.appendln("Такого Id нет");
                return true;
            }
            CityForwarding cityForwarding = (CityForwarding) oArgument;
            City newCity = new City();
            newCity.setId(id);
            newCity.setName(cityForwarding.getName());
            newCity.setCoordinates(cityForwarding.getCoordinates());
            newCity.setCreationDate(ZonedDateTime.now());
            newCity.setArea(cityForwarding.getArea());
            newCity.setPopulation(cityForwarding.getPopulation());
            newCity.setMetersAboveSeaLevel(cityForwarding.getMetersAboveSeaLevel());
            newCity.setCapital(cityForwarding.getCapital());
            newCity.setGovernment(cityForwarding.getGovernment());
            newCity.setStandardOfLiving(cityForwarding.getStandardOfLiving());
            newCity.setHumen(cityForwarding.getGovernor());
            collectionManager.add(newCity);
            ResponseOutput.appendln("Сity успешно обновлен!");
            return true;




    }
}
