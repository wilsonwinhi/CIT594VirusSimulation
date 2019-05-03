
package virusSimulation;

import java.util.*;
import virusSimulation.Plot.Data;
import java.awt.Color;
import java.io.IOException;

public class Simulation {
	/*
	 * main method that runs the virus simulation
	 * 1st argument: virus infectious probability
	 * 2nd argument: seed of the initial infected people
	 * 3rd argument: number of days to simulate
	 * 4th argument: number of times for simulation
	 * @return: percentage of infected people changed with number of days 
	 */
	public static void main(String[] args) {
		int argc = args.length;
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		
		Scanner newScanner = new Scanner(System.in);
		System.out.println("Please provide the probability of the disease: ");
		double probability = newScanner.nextDouble();
		Virus virus = new unmutableVirus(probability,"flu");
		System.out.println("Please provide the number of people initially be inffected: ");
		int seedNum = newScanner.nextInt();
		System.out.println("Please provide the number of days you want to simulate:");
		int days = newScanner.nextInt();
		System.out.println("Please provide the cure Capacity:");
		int cureCapacity = newScanner.nextInt();
		
		/* preprocess to adjacency list */
		List<People> adjList = preprocessMachine.adjPreprocess(textList);
		List<People> adjList2 = preprocessMachine.adjPreprocess(textList);
		List<People> adjList3 = preprocessMachine.adjPreprocess(textList);
		int totalPeople = preprocessMachine.getTotalPeople();
		
		/* process user input */
		/* virus probability */
		//double probability = Double.parseDouble(args[0]);
		/* seed */
		//int seedNum = Integer.parseInt(args[1]);
		/* how many days? */
		//int days = Integer.parseInt(args[2]);
		Random random = new Random();
		
		/* how many simulation times */
		//int times = Integer.parseInt(args[3]);
			/* create seed into queue */
			Queue<People> q = new LinkedList<>();
			Queue<People> q2 = new LinkedList<>();
			Queue<People> q3 = new LinkedList<>();
			List<People> randomSelect = new ArrayList<>();
			boolean[] used = new boolean[totalPeople];
			Infect bfs = new Infect();
			Infect bfs2 = new Infect();
			Infect bfs3 = new Infect();
			while (q.size() < seedNum) {
				int val = random.nextInt(totalPeople);
				if (!used[val]) {
					People toPut = adjList.get(val);
					People toPut2 = adjList2.get(val);
					People toPut3 = adjList3.get(val);
					toPut.gotInfected();
					toPut2.gotInfected();
					toPut3.gotInfected();
					//System.out.println("check==>" + toPut.getSocialNetwork().size());
					randomSelect.add(toPut2);
					q.offer(toPut);
					//bfs.infectedPeopleNum ++;
					q2.offer(toPut2);
					//bfs2.infectedPeopleNum ++;
					q3.offer(toPut3);
					//bfs3.infectedPeopleNum ++;
				}
				used[val] = true;
			}
			
			
			List<Integer> resOfInfectedPpl = bfs.BFS(q, virus, days, adjList);
			List<Integer> resOfInfectedPp2 = bfs2.BFSwithTreatment1(q2,virus, days,adjList2, cureCapacity);
			List<Integer> resOfInfectedPp3 = bfs3.BFSwithTreatment2(q3,virus, days,adjList3,cureCapacity);
			
	//		System.out.println("total people: " + totalPeople);
	//		/* run bfs */
	//		for (int i = 0; i < days; i++) {
	//			infectedPeopleNum += bfs.BFS1Round(q, probability);
	//			System.out.println(infectedPeopleNum);
	//		}
		
			System.out.println(resOfInfectedPpl);
			System.out.println(resOfInfectedPp2);
			System.out.println(resOfInfectedPp3);
			
			
			/* plot */
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
			plot.series("Without Treatment", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.GREEN).
			            color(Color.BLACK));
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp2.size(); i++) {
				d = d.xy(i, resOfInfectedPp2.get(i) / (double) totalPeople);
			}
			plot.series("K-Shell", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.BLUE).
			            color(Color.BLACK));
			d = Plot.data();
			for (int i = 0; i < resOfInfectedPp3.size(); i++) {
				d = d.xy(i, resOfInfectedPp3.get(i) / (double) totalPeople);
			}
			plot.series("Clustering Coefficient", d, Plot.seriesOpts().
			            marker(Plot.Marker.DIAMOND).
			            markerColor(Color.RED).
			            color(Color.BLACK));
			
			try {
				plot.save("virus_simulation", "png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
//			/* plot */
//			plot = Plot.plot(Plot.plotOpts().
//			        title("Virus Simulation").
//			        legend(Plot.LegendFormat.BOTTOM)).
//			    xAxis("x", Plot.axisOpts().
//			        range(0, days)).
//			    yAxis("y", Plot.axisOpts().
//			        range(0, 1));
//			d = Plot.data();
//			for (int i = 0; i < resOfInfectedPp2.size(); i++) {
//				d = d.xy(i, resOfInfectedPp2.get(i) / (double) totalPeople);
//			}
//			plot.series("Data", d, Plot.seriesOpts().
//			            marker(Plot.Marker.DIAMOND).
//			            markerColor(Color.GREEN).
//			            color(Color.BLACK));
//	
//			try {
//				plot.save("virus_simulation" + "_" + 2, "png");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace(); 
//			}
//			/* plot */
//			plot = Plot.plot(Plot.plotOpts().
//			        title("Virus Simulation").
//			        legend(Plot.LegendFormat.BOTTOM)).
//			    xAxis("x", Plot.axisOpts().
//			        range(0, days)).
//			    yAxis("y", Plot.axisOpts().
//			        range(0, 1));
//			d = Plot.data();
//			for (int i = 0; i < resOfInfectedPp3.size(); i++) {
//				d = d.xy(i, resOfInfectedPp3.get(i) / (double) totalPeople);
//			}
//			plot.series("Data", d, Plot.seriesOpts().
//			            marker(Plot.Marker.DIAMOND).
//			            markerColor(Color.GREEN).
//			            color(Color.BLACK));
//	
//			try {
//				plot.save("virus_simulation" + "_" + 3, "png");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace(); 
//			}
	}
}