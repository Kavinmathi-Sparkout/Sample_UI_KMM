package org.example.swipeRefresh

// iOS-specific code (Swift)
import SwiftUI

struct iOSSwipeRefreshView: View {
    @State
    private var isRefreshing = false
    @State
    private var data = ["Item 1", "Item 2", "Item 3"]

    var body: some View {
        List {
            ForEach(data, id: \.self) {
            item in
                    Text(item)
        }
        }
            .refreshable {
                await refreshData ()
            }
    }

    private func refreshData() async {
        isRefreshing = true
        // Simulate a network call
        try ? await Task . sleep (nanoseconds: 2 * 1_000_000_000)
            data.append("New Item")
            isRefreshing = false
        }
}