package business;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Robots {
    private Map<String, Robot> robots;

    public Robots(Map<String, Robot> robots) {
        setRobots(robots);
    }
    
    public Robots(){
        robots = new HashMap<>();
    }

    public Robots(Robots rob){
        setRobots(rob.getRobots());
    }

    public Map<String, Robot> getRobots() {
        Map<String, Robot> auxrobots = new HashMap<>();
        for(Robot n: robots.values()){
            auxrobots.put(n.getCodRobot(), n);
        }
        return auxrobots;
    }

    public void setRobots(Map<String, Robot> robots) {
        this.robots = new HashMap<>();
        for(Robot n: robots.values()){
            this.robots.put(n.getCodRobot(), n);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robots robots1 = (Robots) o;
        return Objects.equals(robots, robots1.robots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(robots);
    }
}
