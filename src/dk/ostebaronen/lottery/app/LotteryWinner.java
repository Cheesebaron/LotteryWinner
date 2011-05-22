package dk.ostebaronen.lottery.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import dk.ostebaronen.lottery.domain.Lot;
import dk.ostebaronen.lottery.domain.Person;
import dk.ostebaronen.lottery.util.LotFileReader;

public class LotteryWinner {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please provide a path to DataSet");
			System.out.println("Usage: java -jar LotteryWinner.jar \"/path/to/file\"");
		} else {
			LotFileReader lfr = new LotFileReader();
			lfr.readFile(args[0]);
			//lfr.readFile("data/test.txt");
			
			ArrayList<Lot> allLots = new ArrayList<Lot>();
			
			for(Person p : lfr.getPersons()) {
				for(Lot l : p.getLots()) {
					allLots.add(l);
				}
			}
			
			Collections.shuffle(allLots);
			
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(allLots.size());
			
			Lot winnerLot = allLots.get(index);
			
			for(Person p : lfr.getPersons()) {
				if (p.getLots().contains(winnerLot)) {
					System.out.println("Winner is:\n" + p.toString());
				}
			}
		}
	}
}
