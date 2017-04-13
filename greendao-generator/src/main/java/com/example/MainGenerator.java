package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {
    public static void main(String[] args) throws Exception{
        Schema schema=new Schema(1,"com.example.andrei.tissotwatches.db");
        Entity entity=schema.addEntity("Watch");

        entity.addIdProperty();
        entity.addStringProperty("model").notNull();
        entity.addStringProperty("caliber").notNull();
        entity.addIntProperty("price").notNull();
        ;

        new DaoGenerator().generateAll(schema,"./app/src/main/java");

    }
}
