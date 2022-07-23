import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharEventTests {

    @Test
    public void attackAndDeathCheck_attacker_4_target_health_10_should_return_6_health() {
        //Arrange
        NonPlayer npc = new NonPlayer();
        npc.setHealth(10);
        Player player = new Player("Player",10,4);
        CharEvent event = new CharEvent("foo", "bar");
        //Act
        event.attackAndDeathCheck(player, npc);
        int npcHealth = npc.getHealth();
        //Assert
        Assertions.assertEquals(6, npcHealth);
    }

    @Test
    public void useItem_damage_item_should_deal_8_damage(){
        //Arrange
        NonPlayer npc = new NonPlayer();
        npc.setHealth(10);
        Player player = new Player("Player",10,4);
        CharEvent event = new CharEvent("foo", "bar");
        //Act
        event.useItem("grenade", "Damage Item", player, npc);
        int health = npc.getHealth();
        //Assert
        Assertions.assertEquals(2, health);
    }

    @Test
    public void useItem_heal_item_should_heal_half_health(){
        //Arrange
        NonPlayer npc = new NonPlayer();
        Player player = new Player("Player",10,4);
        player.setHealth(1);
        CharEvent event = new CharEvent("foo", "bar");
        //Act
        event.useItem("health potion", "Heal Item", player, npc);
        int health = player.getHealth();
        //Assert
        Assertions.assertEquals(6, health);
    }

    @Test
    public void useItem_heal_item_should_not_heal_over_max_health(){
        //Arrange
        NonPlayer npc = new NonPlayer();
        Player player = new Player("Player",10,4);
        player.setHealth(9);
        CharEvent event = new CharEvent("foo", "bar");
        //Act
        event.useItem("health potion", "Heal Item", player, npc);
        int health = player.getHealth();
        //Assert
        Assertions.assertEquals(10, health);
    }
}
