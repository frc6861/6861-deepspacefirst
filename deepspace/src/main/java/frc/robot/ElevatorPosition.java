package frc.robot; 

public enum ElevatorPosition{
    BALLCARGOSHIP(80),HATCHROCKETANDCARGOSHIP(48),BALLLOWROCKETSHIP(70),HATCHMIDROCKETSHIP(119),BALLMIDROCKETSHIP(141),
    HATCHROCKETSHIP(190),BALLTOPROCKETSHIP(212), test(15000);
    private double position;
    public double getPosition(){
      return position;
    }
    ElevatorPosition(double position){
      this.position=position;
    }
  
  }