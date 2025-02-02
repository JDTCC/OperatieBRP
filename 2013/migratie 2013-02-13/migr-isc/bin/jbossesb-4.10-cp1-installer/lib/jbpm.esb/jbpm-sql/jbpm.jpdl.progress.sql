create table JBPM_ACTION (ID_ numeric not null, class character(1) not null, NAME_ varchar(255), ISPROPAGATIONALLOWED_ bit, ACTIONEXPRESSION_ varchar(255), ISASYNC_ bit, REFERENCEDACTION_ numeric, ACTIONDELEGATION_ numeric, EVENT_ numeric, PROCESSDEFINITION_ numeric, EXPRESSION_ varchar(4000), TIMERNAME_ varchar(255), DUEDATE_ varchar(255), REPEAT_ varchar(255), TRANSITIONNAME_ varchar(255), TIMERACTION_ numeric, EVENTINDEX_ integer, EXCEPTIONHANDLER_ numeric, EXCEPTIONHANDLERINDEX_ integer, primary key (ID_));
create table JBPM_BYTEARRAY (ID_ numeric not null, NAME_ varchar(255), FILEDEFINITION_ numeric, primary key (ID_));
create table JBPM_BYTEBLOCK (PROCESSFILE_ numeric not null, BYTES_ varbinary(1024), INDEX_ integer not null, primary key (PROCESSFILE_, INDEX_));
create table JBPM_COMMENT (ID_ numeric not null, VERSION_ integer not null, ACTORID_ varchar(255), TIME_ timestamp, MESSAGE_ varchar(4000), TOKEN_ numeric, TASKINSTANCE_ numeric, TOKENINDEX_ integer, TASKINSTANCEINDEX_ integer, primary key (ID_));
create table JBPM_DECISIONCONDITIONS (DECISION_ numeric not null, TRANSITIONNAME_ varchar(255), EXPRESSION_ varchar(255), INDEX_ integer not null, primary key (DECISION_, INDEX_));
create table JBPM_DELEGATION (ID_ numeric not null, CLASSNAME_ varchar(4000), CONFIGURATION_ varchar(4000), CONFIGTYPE_ varchar(255), PROCESSDEFINITION_ numeric, primary key (ID_));
create table JBPM_EVENT (ID_ numeric not null, EVENTTYPE_ varchar(255), TYPE_ character(1), GRAPHELEMENT_ numeric, PROCESSDEFINITION_ numeric, NODE_ numeric, TRANSITION_ numeric, TASK_ numeric, primary key (ID_));
create table JBPM_EXCEPTIONHANDLER (ID_ numeric not null, EXCEPTIONCLASSNAME_ varchar(4000), TYPE_ character(1), GRAPHELEMENT_ numeric, PROCESSDEFINITION_ numeric, GRAPHELEMENTINDEX_ integer, NODE_ numeric, TRANSITION_ numeric, TASK_ numeric, primary key (ID_));
create table JBPM_ID_GROUP (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(255), TYPE_ varchar(255), PARENT_ numeric, primary key (ID_));
create table JBPM_ID_MEMBERSHIP (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(255), ROLE_ varchar(255), USER_ numeric, GROUP_ numeric, primary key (ID_));
create table JBPM_ID_PERMISSIONS (ENTITY_ numeric not null, CLASS_ varchar(255), NAME_ varchar(255), ACTION_ varchar(255));
create table JBPM_ID_USER (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(255), EMAIL_ varchar(255), PASSWORD_ varchar(255), primary key (ID_));
create table JBPM_JOB (ID_ numeric not null, CLASS_ character(1) not null, VERSION_ integer not null, DUEDATE_ timestamp, PROCESSINSTANCE_ numeric, TOKEN_ numeric, TASKINSTANCE_ numeric, ISSUSPENDED_ bit, ISEXCLUSIVE_ bit, LOCKOWNER_ varchar(255), LOCKTIME_ timestamp, EXCEPTION_ varchar(4000), RETRIES_ integer, NAME_ varchar(255), REPEAT_ varchar(255), TRANSITIONNAME_ varchar(255), ACTION_ numeric, GRAPHELEMENTTYPE_ varchar(255), GRAPHELEMENT_ numeric, NODE_ numeric, primary key (ID_));
create table JBPM_LOG (ID_ numeric not null, CLASS_ character(1) not null, INDEX_ integer, DATE_ timestamp, TOKEN_ numeric, PARENT_ numeric, MESSAGE_ varchar(4000), EXCEPTION_ varchar(4000), ACTION_ numeric, NODE_ numeric, ENTER_ timestamp, LEAVE_ timestamp, DURATION_ numeric, NEWLONGVALUE_ numeric, TRANSITION_ numeric, CHILD_ numeric, SOURCENODE_ numeric, DESTINATIONNODE_ numeric, VARIABLEINSTANCE_ numeric, OLDBYTEARRAY_ numeric, NEWBYTEARRAY_ numeric, OLDDATEVALUE_ timestamp, NEWDATEVALUE_ timestamp, OLDDOUBLEVALUE_ double precision, NEWDOUBLEVALUE_ double precision, OLDLONGIDCLASS_ varchar(255), OLDLONGIDVALUE_ numeric, NEWLONGIDCLASS_ varchar(255), NEWLONGIDVALUE_ numeric, OLDSTRINGIDCLASS_ varchar(255), OLDSTRINGIDVALUE_ varchar(255), NEWSTRINGIDCLASS_ varchar(255), NEWSTRINGIDVALUE_ varchar(255), OLDLONGVALUE_ numeric, OLDSTRINGVALUE_ varchar(4000), NEWSTRINGVALUE_ varchar(4000), TASKINSTANCE_ numeric, TASKACTORID_ varchar(255), TASKOLDACTORID_ varchar(255), SWIMLANEINSTANCE_ numeric, primary key (ID_));
create table JBPM_MODULEDEFINITION (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(4000), PROCESSDEFINITION_ numeric, STARTTASK_ numeric, primary key (ID_));
create table JBPM_MODULEINSTANCE (ID_ numeric not null, CLASS_ character(1) not null, VERSION_ integer not null, PROCESSINSTANCE_ numeric, TASKMGMTDEFINITION_ numeric, NAME_ varchar(255), primary key (ID_));
create table JBPM_NODE (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(255), DESCRIPTION_ varchar(4000), PROCESSDEFINITION_ numeric, ISASYNC_ bit, ISASYNCEXCL_ bit, ACTION_ numeric, SUPERSTATE_ numeric, SUBPROCNAME_ varchar(255), SUBPROCESSDEFINITION_ numeric, DECISIONEXPRESSION_ varchar(255), DECISIONDELEGATION numeric, SCRIPT_ numeric, SIGNAL_ integer, CREATETASKS_ bit, ENDTASKS_ bit, NODECOLLECTIONINDEX_ integer, primary key (ID_));
create table JBPM_POOLEDACTOR (ID_ numeric not null, VERSION_ integer not null, ACTORID_ varchar(255), SWIMLANEINSTANCE_ numeric, primary key (ID_));
create table JBPM_PROCESSDEFINITION (ID_ numeric not null, CLASS_ character(1) not null, NAME_ varchar(255), DESCRIPTION_ varchar(4000), VERSION_ integer, ISTERMINATIONIMPLICIT_ bit, STARTSTATE_ numeric, primary key (ID_));
create table JBPM_PROCESSINSTANCE (ID_ numeric not null, VERSION_ integer not null, KEY_ varchar(255), START_ timestamp, END_ timestamp, ISSUSPENDED_ bit, PROCESSDEFINITION_ numeric, ROOTTOKEN_ numeric, SUPERPROCESSTOKEN_ numeric, primary key (ID_));
create table JBPM_RUNTIMEACTION (ID_ numeric not null, VERSION_ integer not null, EVENTTYPE_ varchar(255), TYPE_ character(1), GRAPHELEMENT_ numeric, PROCESSINSTANCE_ numeric, ACTION_ numeric, PROCESSINSTANCEINDEX_ integer, primary key (ID_));
create table JBPM_SWIMLANE (ID_ numeric not null, NAME_ varchar(255), ACTORIDEXPRESSION_ varchar(255), POOLEDACTORSEXPRESSION_ varchar(255), ASSIGNMENTDELEGATION_ numeric, TASKMGMTDEFINITION_ numeric, primary key (ID_));
create table JBPM_SWIMLANEINSTANCE (ID_ numeric not null, VERSION_ integer not null, NAME_ varchar(255), ACTORID_ varchar(255), SWIMLANE_ numeric, TASKMGMTINSTANCE_ numeric, primary key (ID_));
create table JBPM_TASK (ID_ numeric not null, NAME_ varchar(255), DESCRIPTION_ varchar(4000), PROCESSDEFINITION_ numeric, ISBLOCKING_ bit, ISSIGNALLING_ bit, CONDITION_ varchar(255), DUEDATE_ varchar(255), PRIORITY_ integer, ACTORIDEXPRESSION_ varchar(255), POOLEDACTORSEXPRESSION_ varchar(255), TASKMGMTDEFINITION_ numeric, TASKNODE_ numeric, STARTSTATE_ numeric, ASSIGNMENTDELEGATION_ numeric, SWIMLANE_ numeric, TASKCONTROLLER_ numeric, primary key (ID_));
create table JBPM_TASKACTORPOOL (TASKINSTANCE_ numeric not null, POOLEDACTOR_ numeric not null, primary key (TASKINSTANCE_, POOLEDACTOR_));
create table JBPM_TASKCONTROLLER (ID_ numeric not null, TASKCONTROLLERDELEGATION_ numeric, primary key (ID_));
create table JBPM_TASKINSTANCE (ID_ numeric not null, CLASS_ character(1) not null, VERSION_ integer not null, NAME_ varchar(255), DESCRIPTION_ varchar(4000), ACTORID_ varchar(255), CREATE_ timestamp, START_ timestamp, END_ timestamp, DUEDATE_ timestamp, PRIORITY_ integer, ISCANCELLED_ bit, ISSUSPENDED_ bit, ISOPEN_ bit, ISSIGNALLING_ bit, ISBLOCKING_ bit, TASK_ numeric, TOKEN_ numeric, PROCINST_ numeric, SWIMLANINSTANCE_ numeric, TASKMGMTINSTANCE_ numeric, primary key (ID_));
create table JBPM_TOKEN (ID_ numeric not null, VERSION_ integer not null, NAME_ varchar(255), START_ timestamp, END_ timestamp, NODEENTER_ timestamp, NEXTLOGINDEX_ integer, ISABLETOREACTIVATEPARENT_ bit, ISTERMINATIONIMPLICIT_ bit, ISSUSPENDED_ bit, LOCK_ varchar(255), NODE_ numeric, PROCESSINSTANCE_ numeric, PARENT_ numeric, SUBPROCESSINSTANCE_ numeric, primary key (ID_));
create table JBPM_TOKENVARIABLEMAP (ID_ numeric not null, VERSION_ integer not null, TOKEN_ numeric, CONTEXTINSTANCE_ numeric, primary key (ID_));
create table JBPM_TRANSITION (ID_ numeric not null, NAME_ varchar(255), DESCRIPTION_ varchar(4000), PROCESSDEFINITION_ numeric, FROM_ numeric, TO_ numeric, CONDITION_ varchar(255), FROMINDEX_ integer, primary key (ID_));
create table JBPM_VARIABLEACCESS (ID_ numeric not null, VARIABLENAME_ varchar(255), ACCESS_ varchar(255), MAPPEDNAME_ varchar(255), SCRIPT_ numeric, PROCESSSTATE_ numeric, TASKCONTROLLER_ numeric, INDEX_ integer, primary key (ID_));
create table JBPM_VARIABLEINSTANCE (ID_ numeric not null, CLASS_ character(1) not null, VERSION_ integer not null, NAME_ varchar(255), CONVERTER_ character(1), TOKEN_ numeric, TOKENVARIABLEMAP_ numeric, PROCESSINSTANCE_ numeric, BYTEARRAYVALUE_ numeric, DATEVALUE_ timestamp, DOUBLEVALUE_ double precision, LONGIDCLASS_ varchar(255), LONGVALUE_ numeric, STRINGIDCLASS_ varchar(255), STRINGVALUE_ varchar(4000), TASKINSTANCE_ numeric, primary key (ID_));
create index IDX_ACTION_EVENT on JBPM_ACTION (EVENT_);
create index IDX_ACTION_ACTNDL on JBPM_ACTION (ACTIONDELEGATION_);
create index IDX_ACTION_PROCDF on JBPM_ACTION (PROCESSDEFINITION_);
create index IDX_COMMENT_TOKEN on JBPM_COMMENT (TOKEN_);
create index IDX_COMMENT_TSK on JBPM_COMMENT (TASKINSTANCE_);
create index IDX_DELEG_PRCD on JBPM_DELEGATION (PROCESSDEFINITION_);
create index IDX_JOB_TSKINST on JBPM_JOB (TASKINSTANCE_);
create index IDX_JOB_PRINST on JBPM_JOB (PROCESSINSTANCE_);
create index IDX_JOB_TOKEN on JBPM_JOB (TOKEN_);
create index IDX_MODDEF_PROCDF on JBPM_MODULEDEFINITION (PROCESSDEFINITION_);
create index IDX_MODINST_PRINST on JBPM_MODULEINSTANCE (PROCESSINSTANCE_);
create index IDX_PSTATE_SBPRCDEF on JBPM_NODE (SUBPROCESSDEFINITION_);
create index IDX_NODE_SUPRSTATE on JBPM_NODE (SUPERSTATE_);
create index IDX_NODE_PROCDEF on JBPM_NODE (PROCESSDEFINITION_);
create index IDX_NODE_ACTION on JBPM_NODE (ACTION_);
create index IDX_PLDACTR_ACTID on JBPM_POOLEDACTOR (ACTORID_);
create index IDX_TSKINST_SWLANE on JBPM_POOLEDACTOR (SWIMLANEINSTANCE_);
create index IDX_PROCDEF_STRTST on JBPM_PROCESSDEFINITION (STARTSTATE_);
create index IDX_PROCIN_ROOTTK on JBPM_PROCESSINSTANCE (ROOTTOKEN_);
create index IDX_PROCIN_SPROCTK on JBPM_PROCESSINSTANCE (SUPERPROCESSTOKEN_);
create index IDX_PROCIN_KEY on JBPM_PROCESSINSTANCE (KEY_);
create index IDX_PROCIN_PROCDEF on JBPM_PROCESSINSTANCE (PROCESSDEFINITION_);
create index IDX_RTACTN_PRCINST on JBPM_RUNTIMEACTION (PROCESSINSTANCE_);
create index IDX_RTACTN_ACTION on JBPM_RUNTIMEACTION (ACTION_);
create index IDX_SWIMLINST_SL on JBPM_SWIMLANEINSTANCE (SWIMLANE_);
create index IDX_TASK_TSKNODE on JBPM_TASK (TASKNODE_);
create index IDX_TASK_PROCDEF on JBPM_TASK (PROCESSDEFINITION_);
create index IDX_TASK_TASKMGTDF on JBPM_TASK (TASKMGMTDEFINITION_);
create index IDX_TASKINST_TOKN on JBPM_TASKINSTANCE (TOKEN_);
create index IDX_TASKINST_TSK on JBPM_TASKINSTANCE (TASK_, PROCINST_);
create index IDX_TSKINST_TMINST on JBPM_TASKINSTANCE (TASKMGMTINSTANCE_);
create index IDX_TSKINST_SLINST on JBPM_TASKINSTANCE (SWIMLANINSTANCE_);
create index IDX_TASK_ACTORID on JBPM_TASKINSTANCE (ACTORID_);
create index IDX_TOKEN_PROCIN on JBPM_TOKEN (PROCESSINSTANCE_);
create index IDX_TOKEN_SUBPI on JBPM_TOKEN (SUBPROCESSINSTANCE_);
create index IDX_TOKEN_NODE on JBPM_TOKEN (NODE_);
create index IDX_TOKEN_PARENT on JBPM_TOKEN (PARENT_);
create index IDX_TKVARMAP_CTXT on JBPM_TOKENVARIABLEMAP (CONTEXTINSTANCE_);
create index IDX_TKVVARMP_TOKEN on JBPM_TOKENVARIABLEMAP (TOKEN_);
create index IDX_TRANSIT_TO on JBPM_TRANSITION (TO_);
create index IDX_TRANSIT_FROM on JBPM_TRANSITION (FROM_);
create index IDX_TRANS_PROCDEF on JBPM_TRANSITION (PROCESSDEFINITION_);
create index IDX_VARINST_TKVARMP on JBPM_VARIABLEINSTANCE (TOKENVARIABLEMAP_);
create index IDX_VARINST_PRCINS on JBPM_VARIABLEINSTANCE (PROCESSINSTANCE_);
create index IDX_VARINST_TK on JBPM_VARIABLEINSTANCE (TOKEN_);
create table hibernate_unique_key ( next_hi integer );
insert into hibernate_unique_key values ( 0 );
