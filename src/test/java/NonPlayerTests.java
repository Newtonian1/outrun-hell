import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NonPlayerTests {

    @Test
    public void genNonPlayer_joe_should_return_joe(){
        //Arrange
        NonPlayer npc = NonPlayer.genNonPlayer("Joe");
        //Act
        String npcName = npc.getName();
        int maxHealth = npc.getMaxHealth();
        //Assert
        Assertions.assertEquals("Joe", npcName);
        Assertions.assertEquals(10, maxHealth);
    }

    @Test
    public void genNonPlayer_jeff_should_return_null(){
        //Arrange
        NonPlayer npc = NonPlayer.genNonPlayer("Jeff");
        //Act
        String npcName = npc.getName();
        int maxHealth = npc.getMaxHealth();
        //Assert
        Assertions.assertEquals(null, npcName);
        Assertions.assertEquals(0, maxHealth);
    }

}
