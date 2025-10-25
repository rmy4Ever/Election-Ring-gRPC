-----   --------------
CS324 - ASSIGNMENT TWO
-----   --------------

TITLE : LCR Leader Election Protocol using gRPC


**Student Names**:
Kevin Bolanavatu,
Maria Waqairatavo,
Salote Katia 

**ID**: 
S11198128
S11174090
S11196202

**GitHub**:`https://github.com/rmy4Ever/Election-Ring-gRPC`

---

--------
OVERVIEW - Exercise 3 - Leader Election in a Distributed Ring
--------
This part of the assignment focuses on implementing the LCR Leader Election Protocol using gRPC.
The program simulates a distributed system where multiple peers are connected in a unidirectional ring topology.
Each peer communicates with its successor through remote procedure calls (RPCs) defined in a .proto file.
The objective is to elect a single leader based on the highest unique ID among all peers.

Below is a breakdown of each component:

### `registrationdemo.proto` – gRPC Service Definition
- Defines messages and RPCs for election and leader announcement.

### `Node.java` – Core Node
- Runs gRPC server, handles election logic, retries, shutdown.

### `NodeInterface.java` – Contract
- Ensures consistent node behavior.

### `PeerRegister.java` – Registry
- Registers all 8 nodes at startup.

### `RegistrationDemo.java` – Main
- Sets up ring, starts nodes, provides CLI.

---
------------
CHANGES MADE
------------
- Increased from 4 to **8 nodes**
- IDs: `1, 3, 7, 12, 15, 19, 25, 30`
- **Clear, formatted console output**
- **Full comments** in all classes
- **Interactive CLI** to start election from any node. Just follow the commands displayed on the output screen.

---

----------
HOW TO RUN
----------
1. Open in **NetBeans**
2. Run `RegistrationDemo.java`
3. Type `all` → Leader = 30 (highest ID)

Detailed Instruction:
1. Start the Peer Register Server:
   - Run the main class responsible for registration (e.g., RegisterServer.java).
   - This server maintains the list of all peers and their addresses.

2. Start the Peer Processes:
   - Launch multiple peers (e.g., Peer1.java, Peer2.java, etc.).
   - Each peer will automatically register itself with the register server.
   - Peers will form a logical ring where each node knows only its successor.

3. Initiate the Election:
   - Any peer can start the election process.
   - Each peer sends an ELECTION message containing its own ID to its successor.

4. Election Logic:
   - If a peer receives an ID greater than its own, it forwards the message.
   - If the ID is smaller, it discards the message.
   - If the ID matches its own, it declares itself as the leader and sends a LEADER message around the ring.

---

-------------
PREREQUISITES
-------------
Java 8 or a higher version
Netbeans -> Maven

---

-------------------
PERFORMANCE TESTING
-------------------
When the system runs with multiple peers, the LCR algorithm ensures that only the peer with the highest ID
is elected as the leader. The leader announcement circulates once around the ring, and all peers record the
leader’s ID. The console output will show clear messages for peer registration, election message forwarding,
and final leader announcement.

Example:
Peer 5 sends ELECTION(5)
Peer 11 sends ELECTION(11)
Peer 11 receives ELECTION(11) again and declares itself LEADER

---

---------------
TROUBLESHOOTING
---------------
Below are **common issues** and **solutions** when running the 8-peer leader election demo.

---

### 1. **`Address already in use` / Port Conflict**
Exception: java.net.BindException: Address already in use
**Cause**: Another program (or previous run) is using ports `50051–50058`.

**Fix**:
1. Close all previous runs of the program.
2. In **Task Manager**, end any `java.exe` processes.
3. Or change ports in `RegistrationDemo.java`:
   ```java
   n(12, "127.0.0.1", 60051), // Use 60051–60058

### 2. **gRPC Server Not Starting / No Output**
Symptom: Program runs but no [NODE XX] SERVER STARTED messages.
**Fix**:
Ensure JDK 17+ is selected:
Project → Properties → Sources → Source/Binary Format = 17
Clean & Build:
Run → Clean and Build Project
Check Output tab — look for protoc or grpc errors.

### 3. **Election Never Starts / "Ring not established" **
Error Message:
[NODE 30] Cannot start: ring not formed
**Cause**: Nodes failed to set successors.
**Fix**:
Wait 5–10 seconds after startup.
Check logs for:
[NODE 12] Successor → Node 3

If missing: Restart NetBeans and run again.

### 4. No Leader Elected / Timeout
Message: [NODE XX] Election TIMED OUT
**Cause**: Messages lost due to high load or firewall.
**Fix**:
Run on localhost only (127.0.0.1)
Increase timeout in Node.java:
Thread.sleep(5000); // instead of 3000
Avoid running all command too early.


### 5. Connection Refused Errors:
  - Verify that the Register Server is running before starting peers.

### 6. Java Version:
   - Ensure Java JDK 8 or higher is installed and configured in NetBeans.
   - IDE compatibility issue - Project was developed in NetBeans. If using IntelliJ or Eclipse, verify that all .java files are included and properly compiled.

### 7. Execution Order:
   - Always start the Register Server first before launching peers.

### 8. Leader Not Consensus (Some Nodes Show -1)
**Cause**: Leader message didn’t complete full ring.
**Fix**:
Wait 10 seconds after "I AM THE LEADER!"
Type leader in console to check.
Restart and try election from highest ID (30) first.

### 9.NetBeans Git / Versioning Menu Missing
**Symptom**: No Team → Git or Versioning.
**Fix**:
Tools → Plugins → Installed
Search git → Activate → Restart
Or right-click project → Versioning → Initialize Git Repository

## 10.Compilation Error: Cannot Find Symbol Neighbor
**Cause**: .proto file not compiled.
**Fix**:
Ensure registrationdemo.proto is in:
src/main/proto/

-Clean and Build → NetBeans runs protoc automatically.
-If fails: Install Protobuf Compiler (protoc) and add to PATH.

### 11. Program Hangs on Shutdown
Cause: gRPC server not shutting down cleanly.
Fix:

Press Ctrl+C in Output window.
Or add in RegistrationDemo.java the code below:

Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    nodes.forEach(Node::shutdown);
}));

