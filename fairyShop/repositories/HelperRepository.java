package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class HelperRepository implements Repository<Helper> {
    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }

    @Override
    public void add(Helper helper) {
        this.helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        Optional<Helper> foundHelper = this.helpers.stream()
                .filter(helper -> helper.getName().equals(name))
                .findFirst();

        return foundHelper.orElse(null);
    }
}
