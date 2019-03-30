package frc.robot; 

public enum ElevatorPosition{ //ENTIRE RANGE IS ~38584 pulses
    BALLCARGOSHIP(80), //80 cm wheel bottom 95
    HATCHROCKETANDCARGOSHIP(48), //48 cm
    BALLLOWROCKETSHIP(70), //70 cm
    HATCHMIDROCKETSHIP(119), //119 cm
    BALLMIDROCKETSHIP(141), //141 cm
    HATCHROCKETSHIP(190), //190 cm
    BALLTOPROCKETSHIP(212), //212 cm
    test(15000);
    
    private double position;
    public double getPosition(){
      return position;
    }
    ElevatorPosition(double position){
      this.position=position;
    }
  
  }