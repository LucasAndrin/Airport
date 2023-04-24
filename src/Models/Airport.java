package Models;

import lists.Knot;
import lists.QueueList;

import java.util.ArrayList;

public class Airport {

    public int time = 0;

    private int takingOffId = 0;

    private int landingId = 1;

    public ArrayList<Integer> takingOffTimes = new ArrayList<Integer>();

    public ArrayList<Integer> landingTimes = new ArrayList<Integer>();

    private final Track primaryTrack = new Track();

    private final Track secondaryTrack = new Track();

    public Airport() { }

    public Plane addPlaneLanding(int gas) {
        Plane plane = new Plane(time, landingId, gas);
        int primaryTrackLandingLength = primaryTrack.getLanding().getLength();
        int primaryTrackTakingOffLength = primaryTrack.getTakingOff().getLength();

        int secondaryTrackLandingLength = secondaryTrack.getLanding().getLength();
        int secondaryTrackTakingOffLength = secondaryTrack.getTakingOff().getLength();

        if (primaryTrackLandingLength < secondaryTrackLandingLength) {
            primaryTrack.setPlaneLanding(plane);
        } else if (primaryTrackLandingLength > secondaryTrackLandingLength) {
            secondaryTrack.setPlaneLanding(plane);

        } else if (primaryTrackTakingOffLength >= secondaryTrackTakingOffLength) {
            primaryTrack.setPlaneLanding(plane);
        } else {
            secondaryTrack.setPlaneLanding(plane);
        }

        incrementLandingId();

        return plane;
    }

    public Plane addPlaneTakingOff() {
        Plane plane = new Plane(time, takingOffId);
        int primaryTrackLength = primaryTrack.getTakingOff().getLength() + primaryTrack.getLanding().getLength();
        int secondaryTrackLength = secondaryTrack.getTakingOff().getLength() + secondaryTrack.getLanding().getLength();

        if (primaryTrackLength < secondaryTrackLength) {
            primaryTrack.setPlaneTakingOff(plane);
        } else if (primaryTrackLength > secondaryTrackLength) {
            secondaryTrack.setPlaneTakingOff(plane);
        } else if (primaryTrack.getLanding().getLength() <= secondaryTrack.getLanding().getLength()) {
            primaryTrack.setPlaneTakingOff(plane);
        } else {
            secondaryTrack.setPlaneTakingOff(plane);
        }

        takingOffId += 2;

        return plane;
    }

    public void manageAirport() {
        boolean primaryLandedSomePlane = landPlane(primaryTrack , "1");
        if (!primaryLandedSomePlane) {
            takeOffPlane(primaryTrack, "1");
        }

        boolean secondaryLandedSomePlane = landPlane(secondaryTrack , "2");
        if (!secondaryLandedSomePlane) {
            takeOffPlane(secondaryTrack, "2");
        }

        incrementTime();
        decrementGas(primaryTrack);
        decrementGas(secondaryTrack);
    }

    public boolean landPlane(Track track, String trackId) {
        QueueList landing = track.getLanding();
        Knot aux = landing.getStart();
        Knot trackLessFuel = aux;

        while (aux != null) {
            Plane plane = (Plane) aux.getObject();
            Knot next = aux.getNext();
            if (next != null) {
                Plane nextPlane = (Plane) next.getObject();
                if (plane.getGas() <= nextPlane.getGas()) {
                    trackLessFuel = aux;
                } else {
                    trackLessFuel = next;
                }
            }
            aux = next;
        }

        if (trackLessFuel != null) {
            Plane planeLessFuel = (Plane) trackLessFuel.getObject();
            landingTimes.add(time - planeLessFuel.getTime());
            if (planeLessFuel.getGas() < 10 || track.getTakingOff().getLength() == 0) {
                System.out.println(trackId + "ª Pista está pousando o avião: " + planeLessFuel);
                landing.removeObj(trackLessFuel);
            }
            return true;
        }

        return false;
    }

    public void takeOffPlane(Track track, String trackId) {
        QueueList takingOff = track.getTakingOff();
        Knot start = takingOff.getStart();
        if (start != null) {
            Plane planeTakingOff = (Plane) start.getObject();
            takingOffTimes.add(time - planeTakingOff.getTime());
            System.out.println(trackId + "º Pista está decolando o avião: " + planeTakingOff);
            takingOff.remove();
        }
    }

    public void decrementGas(Track track) {
        Knot aux = track.getLanding().getStart();
        while (aux != null) {
            Plane plane = (Plane) aux.getObject();
            plane.setGas(plane.getGas() - 1);
            if (plane.getGas() == 0) {
                System.out.println("AVIÃO " + plane.getId() + " CAINDO!!");
            }
            aux = aux.getNext();
        }
    }

    public void incrementTime() {
        time++;
    }

    public Track getPrimaryTrack() {
        return primaryTrack;
    }

    public Track getSecondaryTrack() {
        return secondaryTrack;
    }

    public void incrementLandingId() {
        landingId = landingId + 2;
    }

    public int getTakingOffId() {
        return takingOffId;
    }

    public int getLandingId() {
        return landingId;
    }
}
