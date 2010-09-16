// This file is part of the "IBController".
// Copyright (C) 2004 Steven M. Kearns (skearns23@yahoo.com )
// Copyright (C) 2004, 2005, 2006, 2007, 2008, 2009, 2010 Richard L King (rlking@aultan.com)
// For conditions of distribution and use, see copyright notice in COPYING.txt

// IBController is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// IBController is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with Foobar.  If not, see <http://www.gnu.org/licenses/>.

package ibcontroller;

import java.awt.Window;
import javax.swing.JDialog;

class BlindTradingWarningDialogHandler implements WindowHandler {
    public void handleWindow(Window window, int eventID) {
        if (! Settings.getBoolean("AllowBlindTrading", false)) return;

        if (! Utils.clickButton(window, "Yes")) {
            System.err.println("IBController: could not dismiss blind trading warning dialog.");
        }
    }

    public boolean recogniseWindow(Window window) {
        if (! (window instanceof JDialog)) return false;
        return (Utils.findLabel(window, "blind trading") != null &&
                Utils.findLabel(window, "Are you sure you want to submit this order?") != null);
    }

}