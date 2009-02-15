package com.iaic.searchs;

import java.util.List;

import aima.search.framework.QueueSearch;
import aima.search.framework.Search;
import aima.search.informed.AStarSearch;
import aima.search.informed.GreedyBestFirstSearch;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.HillClimbingSearch.SearchOutcome;
import aima.search.uninformed.BreadthFirstSearch;
import aima.search.uninformed.DepthFirstSearch;
import aima.search.uninformed.UniformCostSearch;

public class Searches {

	public static final int DEPTH = 0;
	public static final int LIMITED_DEPTH = 1;
	public static final int ITERATIVE_DEPTH = 2;
	public static final int WIDTH = 3;
	public static final int UNIFORM_COST = 4;
	public static final int SIMPLE_CLIMBING = 5;
	public static final int MAXIMUM_SLOPE_CLIMBING = 6;
	public static final int A_STAR = 7;
	public static final int GREEDY = 8;
	
	public static  String[] SEARCH_TYPES = {
		"Profundidad",
		"Profundidad limitada",
		"Profundidad iterativa",
		"Anchura",
		"CosteUniforme",
		"Escalada simple",
		"Escalada máxima pendiente",
		"A*",
		"Greedy"
	};
	
	public static final int WITHOUTH_CONTROL = 0;
	public static final int BRANCH_CYCLE_CONTROL = 1;
	public static final int TOTAL_CYCLE_CONTROL = 2;
	public static final int BRANCH_CYCLE_CONTROL_2 = 3;
	public static final int TOTAL_CYCLE_CONTROL_2 = 4;

	public static  String[] CONTROL_TYPES = {
		"Sin Control de Ciclos",
		"Control de ciclos en rama",
		"Control de ciclos total",
		"Control de ciclos en rama-2",
		"Control de ciclos total-2"
	};
	
	public static  String[] CONTROL_TYPES_A={
		"Sin Control de Ciclos",
		"Control de ciclos en rama"
	};
	
	public static Search getSearch ( String type , ConditionTest conditionTest , Object parameter ) {
		Search search = null;
		QueueSearch cycleControl = null;
		if (type.equals(SEARCH_TYPES[DEPTH]) || 
			type.equals(SEARCH_TYPES[WIDTH]) ||
			type.equals(SEARCH_TYPES[UNIFORM_COST]) || 
			type.equals(SEARCH_TYPES[GREEDY])){
				String controlType = (String) parameter;
				if (controlType.equals(CONTROL_TYPES[WITHOUTH_CONTROL])){
					cycleControl = new ConditionalQueueSearch(conditionTest);
				}else if (controlType.equals(CONTROL_TYPES[BRANCH_CYCLE_CONTROL])){
					cycleControl = new BranchCycleControlConditionalQueueSearch(conditionTest);
				}else if (controlType.equals(CONTROL_TYPES[TOTAL_CYCLE_CONTROL])){
					cycleControl = new CycleControlTotalConditionalQueueSearch(conditionTest);
				}else if (controlType.equals(CONTROL_TYPES[BRANCH_CYCLE_CONTROL_2])){
					cycleControl = new BranchCycleControlConditionalQueueSearch2(conditionTest);
				}else if (controlType.equals(CONTROL_TYPES[TOTAL_CYCLE_CONTROL_2])){
					cycleControl = new ControlDeCiclosTotalCondicionalQueueSearch2(conditionTest);
				}
		}
		if (type.equals(SEARCH_TYPES[A_STAR])){
			String controlType=(String) parameter;
			if (controlType.equals(CONTROL_TYPES[WITHOUTH_CONTROL])){
				cycleControl=new ConditionalQueueSearch(conditionTest);
			}else if (controlType.equals(CONTROL_TYPES[BRANCH_CYCLE_CONTROL])){
				cycleControl =new BranchCycleControlConditionalQueueSearch(conditionTest);
			}
		}
		
		Integer limit = new Integer(0);
		if (type == SEARCH_TYPES[LIMITED_DEPTH]){
			limit =(Integer) parameter;
		}
		
		if (type == SEARCH_TYPES[DEPTH]){
			search = new DepthFirstSearch (cycleControl);
		}else if (type == SEARCH_TYPES[LIMITED_DEPTH]){
			search = new LimitedDepthSearch(limit.intValue(),conditionTest);
		}else if (type == SEARCH_TYPES[ITERATIVE_DEPTH]){
			search=new IterativeDepthSearch (conditionTest);
		}else if (type == SEARCH_TYPES[WIDTH]){
			search = new BreadthFirstSearch (cycleControl);
		}else if (type == SEARCH_TYPES[UNIFORM_COST]){
			search = new UniformCostSearch (cycleControl);
		}else if (type == SEARCH_TYPES[SIMPLE_CLIMBING]){
			search = new SimpleClimbingSearch (conditionTest);	
		}else if (type == SEARCH_TYPES[MAXIMUM_SLOPE_CLIMBING]){
			search = new MaximumSlopeClimbingSearch (conditionTest);
		}else if (type == SEARCH_TYPES[A_STAR]){
			search = new AStarSearch (cycleControl);
		}else if (type == SEARCH_TYPES[GREEDY]){
			search = new GreedyBestFirstSearch (cycleControl);
		}
		
		return search;
	}

	public static boolean finalizedSearch(Search search, List actions) {
		boolean end = true;
		if (search instanceof LimitedDepthSearch ||
				search instanceof IterativeDepthSearch){
			end = !(actions.size()==1 && 
							(actions.get(0).equals(IterativeDepthSearch.MAXIMUM_ITERATION) ||
							actions.get(0).equals(LimitedDepthSearch.CORTE)));
		}else if (search instanceof SimpleClimbingSearch ||
				search instanceof MaximumSlopeClimbingSearch){
			HillClimbingSearch climbing=(HillClimbingSearch) search;
			SearchOutcome exit = climbing.getOutcome();
			end = exit.equals(SearchOutcome.SOLUTION_FOUND);
		}else{
			end=!(actions.size()==1 && 
						actions.get(0).equals(ConditionalQueueSearch.ABIERTOS_VACIO));	
		}		
		return end;
	}
}
