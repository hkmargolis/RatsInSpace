package Enemy;

public class Enemy {
    String name;
    int hp;
    String size;

    public Enemy() {

    }
    public void setEnemyName(String name){
        this.name = name;
    }
    public String getEnemyName() {
        return this.name;
    }

    public void setEnemyHp(int hp) {
        this.hp = hp;
    }

    public int getEnemyHp() {
        return this.hp;
    }

    public void setEnemySize(String size) {
        this.size = size;
    }

    public String getEnemySize() {
        return this.size;
    }


}
