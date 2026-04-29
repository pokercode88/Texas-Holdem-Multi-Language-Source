
#-----------------------------------------------------------------------

APP            := XGame
TARGET         := RoomServer
STRIP_FLAG     := N
TARS2CPP_FLAG  := 
CFLAGS         += -lm -ldl -Wunused-variable
CXXFLAGS       += -lm -ldl -Wunused-variable

INCLUDE   +=  -I. -I/usr/local/cpp_modules/protobuf/include
LIB       += /usr/local/cpp_modules/protobuf/lib/libprotobuf.a

INCLUDE   += -I/usr/local/cpp_modules/wbl/include
LIB       += -L/usr/local/cpp_modules/wbl/lib -lwbl -ldl

INCLUDE	  += -L/usr/local/cpp_modules/maxminddb/include
LIB		  += -L/usr/local/cpp_modules/maxminddb/lib -lmaxminddb

INCLUDE   += -I./XTimer -I./AsyncOperate -I./AsyncOperate/HallServer \
			 -I./BPTableMng -I./CommTableMng -I./PRTableMng -I./SNGTableMng -I./MTTableMng -I./CBTableMng\
			 -I./AIMng -I./AIMng/MonteCarlo -I./AIMng/ThirdParty

LOCAL_SRC += AIMng/AiMng.cpp AIMng/MonteCarlo/cards.cpp AIMng/MonteCarlo/samples.cpp  \
 			 AIMng/MonteCarlo/tables.cpp AIMng/MonteCarlo/tools.cpp AIMng/MonteCarlo/simulator.cpp

LOCAL_SRC += AIMng/ThirdParty/ThirdPartyManager.cpp AIMng/ThirdParty/AsyncEpoller.cpp \
			 AIMng/ThirdParty/AsyncSocket.cpp AIMng/ThirdParty/ThirdLog.cpp \
			 AIMng/ThirdParty/NetMsg.cpp AIMng/ThirdParty/RawBuffer.cpp AIMng/ThirdParty/TcpClient.cpp

LOCAL_SRC += PRTableMng/PRTableMng.cpp SNGTableMng/SNGTableMng.cpp MTTableMng/MTTableMng.cpp CBTableMng/CBTableMng.cpp \
			 BPTableMng/BPTableMng.cpp CommTableMng/RTableMng.cpp CommTableMng/GTableMng.cpp \
			 XTimer/xtimer.cpp XTimer/xtime_userface.cpp 

LOCAL_SRC += AsyncOperate/HallServer/AsyncUserInfoCallback.cpp
#-----------------------------------------------------------------------
include /home/tarsproto/XGame/Comm/Comm.mk
include /home/tarsproto/XGame/util/util.mk
include /home/tarsproto/XGame/protocols/protocols.mk
include /home/tarsproto/XGame/RouterServer/RouterServer.mk
include /home/tarsproto/XGame/HallServer/HallServer.mk
include /home/tarsproto/XGame/ConfigServer/ConfigServer.mk
include /home/tarsproto/XGame/GlobalServer/GlobalServer.mk
include /home/tarsproto/XGame/PushServer/PushServer.mk
include /home/tarsproto/XGame/GameRecordServer/GameRecordServer.mk
include /home/tarsproto/XGame/ActivityServer/ActivityServer.mk
include /home/tarsproto/XGame/Log2DBServer/Log2DBServer.mk
include /home/tarsproto/XGame/SocialServer/SocialServer.mk
include /home/tarsproto/XGame/OrderServer/OrderServer.mk
include /home/tarsproto/XGame/GMServer/GMServer.mk
include /usr/local/tars/cpp/makefile/makefile.tars
#-----------------------------------------------------------------------

xgame:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/QSFGame.RoomServer/bin/

100:
	sshpass -p 'awzs2022' scp ./RoomServer root@10.10.10.100:/home/yuj/server/roomserver

qsgame:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/QSGame.RoomServer/bin/

qsgamea:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/QSGameA.RoomServer/bin

qsgamei:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/QSGameI.RoomServer/bin

kogame:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/KOGame.RoomServer/bin/

kogamea:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/KOGameA.RoomServer/bin/

kogameb:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/KOGameB.RoomServer/bin/

kogamec:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/KOGameC.RoomServer/bin/

kogamed:
	cp -f $(TARGET) /usr/local/app/tars/tarsnode/data/KOGameD.RoomServer/bin/

