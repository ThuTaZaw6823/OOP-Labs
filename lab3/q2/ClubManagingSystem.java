package lab3.q2;

public class ClubManagingSystem {

    private Club[] clubList;

    public ClubManagingSystem(Club[] clubList) {
        this.clubList = clubList;
    }

    public int determineAllBudget() {
        int total = 0;

        for (Club club : clubList) {
            total += club.determineBudget();
        }

        return total;
    }

    public int getAllMembers() {
        int total = 0;

        for (Club club : clubList) {
            total += club.getNumMember();
        }

        return total;
    }

    public Club getHighestMemberClub() {
        Club highest = clubList[0];

        for (Club club : clubList) {
            if (club.getNumMember() > highest.getNumMember()) {
                highest = club;
            }
        }

        return highest;
    }
}
