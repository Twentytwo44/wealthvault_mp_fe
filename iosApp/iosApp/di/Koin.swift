
import Foundation
import ComposeApp

func startDI() {
    type(of: KoinInitializer.shared).init()
}
