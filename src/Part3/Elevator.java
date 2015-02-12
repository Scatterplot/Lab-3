package Part3;

import java.util.Random;

public class Elevator
{
    public final int MAX_CAPACITY = 10;
    public final int NUM_FLOORS = 7;
    
    private final Random random = new Random(911);
    public Floor[] floors;
    private int passengerCount;
    private int currentFloor;
    private boolean movingUp;
    private int[] passengerTargets;
    private boolean[] stops;

    public Elevator()
    {
        floors = new Floor[NUM_FLOORS];
        currentFloor = 0;
        passengerCount = 0;
        movingUp = true;
        passengerTargets = new int[NUM_FLOORS];
        stops = new boolean[NUM_FLOORS];
        
        for (int i = 0; i < NUM_FLOORS; i++)
        {
            floors[i] = new Floor(i+1);
            
            int waitingPassengers = random.nextInt()%25;
            boolean direction = random.nextBoolean();
            
            for (int j = 0; j < waitingPassengers; j++)
            {
                passengerTargets[i]++;
                floors[i].addPassenger(direction);
                stops[i] = true;
            }
        }
    }

    public void move() {
        if (movingUp)
        {
            currentFloor++;
        }
        else
        {
            currentFloor--;
        }
        
        if (currentFloor == 0)
        {
            movingUp = true;
        }
        else if (currentFloor == NUM_FLOORS - 1)
        {
            movingUp = false;
        }
        
        if (stops[currentFloor] || passengerTargets[currentFloor] != 0)
        {
            stop();
        }
    }

    public void stop()
    {
        System.out.println("\r\nStopping on floor " + (currentFloor + 1));
        System.out.println(this);
        System.out.println("Unloaded: "+passengerTargets[currentFloor]);
        passengerTargets[currentFloor] = 0;
        stops[currentFloor] = false;
        floors[currentFloor].unloadPassengers(this, movingUp);
    }

    public void boardPassenger(int floor) throws ElevatorFullException
    {
        if (passengerCount < MAX_CAPACITY)
        {
            floor--;
            passengerTargets[floor]++;
            stops[floor] = true;
            passengerCount++;
        }
        else
        {
            throw new ElevatorFullException();
        }
    }
    
    public void registerRequest(int floor)
    {
        stops[floor] = true;
    }

    public String toString() {
        return "Current Passengers: " + passengerCount + "\r\nCurrent Floor: " + (currentFloor + 1) + "\r\nDirection: " + (movingUp ? "Up" : "Down");
    }

    static public void main(String argv[])
    {
        Elevator elev = new Elevator();
        
        System.out.println("\n-- Generated Manifest --");
        for (int i = elev.NUM_FLOORS - 1; i >= 0; i--)
        {
            System.out.println("Floor "+(i+1)+": "+elev.passengerTargets[i]+" passengers");
        }
        
        System.out.println("\n-- Simulation Start --");
        
        for (int i = 0; i < 20; i++)
        {
            elev.move();
        }
    }
    
    public class ElevatorFullException extends java.lang.Exception
    {
        public ElevatorFullException(String message)
        {
            super(message);
        }
        
        public ElevatorFullException()
        {
            super();
        }
    }
}
