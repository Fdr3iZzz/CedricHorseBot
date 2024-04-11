# What is this?
This is a little extension/ add-on for the meteor client wrote for a friend (something quick and dirty)

# Features:
- Walk back and forth in a straight line (one way takes 16 seconds).
- Automatically aligns you every tick.

# Possible issues:
- On tick desync, one can walk further.
- Moving the mouse at a bad timing could result in problems (possible but extremely unlikely).
- Getting moved externally (hit, newly placed block, fishing rod, etc.) results in losing the original line.
- Looks suspicious.

# Future features:
- Settings to select custom time.
- Use block distance instead of time.
- Track coordinates to detect if edge case happens and player leaves line to act accordingly (leave, go back to starting coordinates, reset, etc.).

# Useful features that should already exist:
- Auto-eat to prevent starvation.
- Auto-disconnect when health is too low.
- Killaura to fight mobs or players that can disturb.
