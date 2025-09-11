import time

while True:
    print("Current Time:", time.strftime("%H:%M:%S", time.gmtime()))
    time.sleep(2)
