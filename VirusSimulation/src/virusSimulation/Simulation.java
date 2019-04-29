package virusSimulation;

import java.util.*;

import virusSimulation.Plot.Data;

import java.awt.Color;
import java.io.IOException;

public class Simulation {
	public static void main(String[] args) {
		int argc = args.length;
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		
		/* preprocess to adjacency list */
		List<People> adjList = preprocessMachine.adjPreprocess(textList);
		int totalPeople = preprocessMachine.getTotalPeople();
		
		/* process user input */
		/* virus probability */
		double probability = Double.parseDouble(args[0]);
		/* seed */
		int seedNum = Integer.parseInt(args[1]);
		/* how many days? */
		int days = Integer.parseInt(args[2]);
		Random random = new Random();
		
		/* how many simulation times */
		int times = Integer.parseInt(args[3]);
		for (int r = 0; r < times; r++) {
			/* create seed into queue */
			Queue<People> q = new LinkedList<>();
			
			
			boolean[] used = new boolean[totalPeople];
			while (q.size() < seedNum) {
				int val = random.nextInt(totalPeople);
				if (!used[val]) {
					People toPut = adjList.get(val);
					toPut.gotInfected();
					System.out.println("check==>" + toPut.getSocialNetwork().size());
					q.offer(toPut);
				}
				used[val] = true;
			}
			
			test bfs = new test();
			List<Integer> resOfInfectedPpl = bfs.BFS1Round(q, probability, days, adjList);
	//		System.out.println("total people: " + totalPeople);
	//		/* run bfs */
	//		for (int i = 0; i < days; i++) {
	//			infectedPeopleNum += bfs.BFS1Round(q, probability);
	//			System.out.println(infectedPeopleNum);
	//		}
		
			Plot plot = Plot.plot(Plot.plotOpts().
			        title("Virus Simulation").
			        legend(Plot.LegendFormat.BOTTOM)).
			    xAxis("x", Plot.axisOpts().
			        range(0, days)).
			    yAxis("y", Plot.axisOpts().
			        range(0, 1));
			Data d = Plot.data();
			for (int i = 0; i < resOfInfectedPpl.size(); i++) {
				d = d.xy(i, resOfInfectedPpl.get(i) / (double) totalPeople);
			}
			plot.series("Data", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.GREEN).
			            color(Color.BLACK));
	
			try {
				plot.save("virus_simulation" + "_" + r, "png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/* reset unhealthy to healthy */
			for (People p : adjList) {
				p.isHealthy = true;
			}
		}
	}
}
