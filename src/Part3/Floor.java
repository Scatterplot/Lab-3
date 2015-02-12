package Part3;

import Part3.Elevator.ElevatorFullException;

public class Floor
{
    private int floorNum;
    private int passengersUp;
    private int passengersDown;

    public Floor(int floor)
    {
        floorNum = floor;
        passengersUp = 0;
        passengersDown = 0;
    }

    public void unloadPassengers(Elevator elev, boolean going_up)
    {
        int passengers = going_up ? passengersUp : passengersDown;
        int passengerOld = passengers;
        for (; passengers > 0; passengers--)
        {
            try
            {
                elev.boardPassenger(1);
            }
            catch (ElevatorFullException e)
            {
                System.out.println(e.getMessage());
                elev.registerRequest(floorNum);
                break;
            }
        }
        System.out.println("Loaded: "+(passengerOld-passengers));

        if (going_up)
        {
            passengersUp = passengers;
        }
        else
        {
            passengersDown = passengers;
        }
    }

    /**
     * Testing function
     */
    public void addPassenger(boolean going_up)
    {
        if (going_up)
        {
            passengersUp++;
        } else
        {
            passengersDown++;
        }
    }
    
    public String toString()
    {
        return "Floor: "+floorNum+", Passengers Up: "+passengersUp+", Passengers Down: "+passengersDown; //STUB
    }
}
