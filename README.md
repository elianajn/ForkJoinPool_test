Implement the Fork/Join Framework to parallelize a merge sort
* “Forking” - recursively breaking up tasks into smaller subtasks until simple enough to execute asynchronously/reaches a certain threshold
* “Joining”- subtasks recursively join, if they return a result, all results recursively combined into a single result

# General Steps
1. Create fork join pool (thread pool) instance
2. Implement recursive action or recursive task in your class that is “solving a problem”
3. Compute method- creates new recursive action objects and runs in parallel in the pool
4. invokeAll- forks and joins the tasks in the right order

Eliana Neurohr, Elise Glaser, Madeline Strasser, Meredith Fossitt
